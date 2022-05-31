import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from '../model/album.model';
import { AlbumService } from '../service/album.service';

@Component({
  selector: 'app-album-form',
  templateUrl: './album-form.component.html',
  styleUrls: ['./album-form.component.scss']
})
export class AlbumFormComponent implements OnInit {
  mode: 'NEW' | 'UPDATE' = 'NEW';
  albumId?: number;
  album?: Album;

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService
  ) { }

  ngOnInit(): void {
    const entryParam: string =
    this.route.snapshot.paramMap.get('albumId') ?? 'new';
  if (entryParam !== 'new') {
    this.albumId = +this.route.snapshot.paramMap.get('albumId')!;
    this.mode = 'UPDATE';
    this.getAlbumById(this.albumId!);
  } else {
    this.mode = 'NEW';
    this.initializeAlbum();
  }
  }

  public saveAlbum(): void {
    if (this.mode === 'NEW') {
      this.insertAlbum();
    }

    if (this.mode === 'UPDATE') {
      this.updateAlbum();
    }
  }

  public includeImageInAlbum(event: any): void {
    const inputFile = event.target as HTMLInputElement;
    const file: File | null = inputFile.files?.item(0) ?? null;

    this.readFileAsString(file!).then(
      (result) => {
        const imageType: string = this.getImageType(result);
        console.log(imageType);
        const imageBase64: string = this.getImageBase64(result);
        console.log(imageBase64);

        this.album!.image = imageBase64;
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

  private insertAlbum(): void {
    this.albumService.insert(this.album!).subscribe({
      next: (albumInserted) => {
        console.log('Insertado correctamente');
        console.log(albumInserted);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private updateAlbum(): void {
    this.albumService.update(this.album!).subscribe({
      next: (albumUpdated) => {
        console.log('Modificado correctamente');
        console.log(albumUpdated);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private getAlbumById(albumId: number) {
    this.albumService.getAlbumById(albumId).subscribe({
      next: (albumRequest) => {
        this.album = albumRequest;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private initializeAlbum(): void {
    this.album = new Album(undefined, '', '', '');
  }

  private handleError(err: any): void {
    // ToDo
  }

  }
