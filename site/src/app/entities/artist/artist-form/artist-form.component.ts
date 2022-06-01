import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Artist } from '../model/artist.model';
import { ArtistService } from '../service/artist.service';

@Component({
  selector: 'app-artist-form',
  templateUrl: './artist-form.component.html',
  styleUrls: ['./artist-form.component.scss'],
})
export class ArtistFormComponent implements OnInit {
  mode: 'NEW' | 'UPDATE' = 'NEW';
  artistId?: number;
  artist?: Artist;

  constructor(
    private route: ActivatedRoute,
    private artistService: ArtistService
  ) {}

  ngOnInit(): void {
    const entryParam: string =
      this.route.snapshot.paramMap.get('artistId') ?? 'new';
    if (entryParam !== 'new') {
      this.artistId = +this.route.snapshot.paramMap.get('artistId')!;
      this.mode = 'UPDATE';
      this.getArtistById(this.artistId!);
    } else {
      this.mode = 'NEW';
      this.initializeArtist();
    }
  }

  public saveArtist(): void {
    if (this.mode === 'NEW') {
      this.insertArtist();
    }

    if (this.mode === 'UPDATE') {
      this.updateArtist();
    }
  }

  public includeImageInArtist(event: any): void {
    const inputFile = event.target as HTMLInputElement;
    const file: File | null = inputFile.files?.item(0) ?? null;

    this.readFileAsString(file!).then(
      (result) => {
        const imageType: string = this.getImageType(result);
        console.log(imageType);
        const imageBase64: string = this.getImageBase64(result);
        console.log(imageBase64);

        this.artist!.avatar = imageBase64;
      },
      (error) => {
        console.log('No se pudo cargar la imagen');
      }
    );
  }

  private getImageType(imageString: string): string {
    const imageStringParts: string[] = imageString.split(',');
    if (imageStringParts.length == 2) {
      return imageStringParts[0];
    } else {
      return '';
    }
  }

  private getImageBase64(imageString: string): string {
    const imageStringParts: string[] = imageString.split(',');
    if (imageStringParts.length == 2) {
      return imageStringParts[1];
    } else {
      return '';
    }
  }

  private readFileAsString(file: File) {
    return new Promise<string>(function (resolve, reject) {
      let reader: FileReader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = function () {
        resolve(this.result as string);
      };
    });
  }

  private insertArtist(): void {
    this.artistService.insert(this.artist!).subscribe({
      next: (artistInserted) => {
        console.log('Insertado correctamente');
        console.log(artistInserted);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private updateArtist(): void {
    this.artistService.update(this.artist!).subscribe({
      next: (artistUpdated) => {
        console.log('Modificado correctamente');
        console.log(artistUpdated);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private getArtistById(artistId: number) {
    this.artistService.getArtistById(artistId).subscribe({
      next: (artistRequest) => {
        this.artist = artistRequest;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private initializeArtist(): void {
    this.artist = new Artist(undefined, '', '');
  }

  private handleError(error: any): void {
    console.log(error);
  }
}
