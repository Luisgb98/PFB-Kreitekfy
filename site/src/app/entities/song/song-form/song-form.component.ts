import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from '../../album/model/album.model';
import { AlbumService } from '../../album/service/album.service';
import { Artist } from '../../artist/model/artist.model';
import { ArtistService } from '../../artist/service/artist.service';
import { Genre } from '../../genre/model/genre.model';
import { GenreService } from '../../genre/service/genre.service';
import { Song } from '../model/song.model';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-song-form',
  templateUrl: './song-form.component.html',
  styleUrls: ['./song-form.component.scss'],
})
export class SongFormComponent implements OnInit {
  mode: 'NEW' | 'UPDATE' = 'NEW';
  songId?: number;
  song?: Song;
  selectedGenre?: Genre;
  genres: Genre[] = [];
  selectedArtist?: Artist;
  artists: Artist[] = [];
  selectedAlbum?: Album;
  albums: Album[] = [];
  album?: Album;

  constructor(
    private route: ActivatedRoute,
    private songService: SongService,
    private genreService: GenreService,
    private artistService: ArtistService,
    private albumService: AlbumService
  ) {}

  ngOnInit(): void {
    const entryParam: string =
      this.route.snapshot.paramMap.get('songId') ?? 'new';
    if (entryParam !== 'new') {
      this.songId = +this.route.snapshot.paramMap.get('songId')!;
      this.mode = 'UPDATE';
      this.getSongById(this.songId!);
    } else {
      this.mode = 'NEW';
      this.initializeSong();
    }
  }

  public getAllGenres(event?: any): void {
    let genreSearch: string | undefined;
    if (event?.query) {
      genreSearch = event.query;
    }
    this.genreService.getAllGenres(genreSearch).subscribe({
      next: (genresFiltered) => {
        this.genres = genresFiltered;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  public genreSelected(): void {
    this.song!.genreId = this.selectedGenre!.id;
    this.song!.genreName = this.selectedGenre!.name;
  }

  public genreUnselected(): void {
    this.song!.genreId = undefined;
    this.song!.genreName = '';
  }

  public getAllArtists(event?: any): void {
    let artistSearch: string | undefined;
    if (event?.query) {
      artistSearch = event.query;
    }
    this.artistService.getAllArtists(artistSearch).subscribe({
      next: (artistsFiltered) => {
        this.artists = artistsFiltered;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  public artistSelected(): void {
    this.song!.artistId = this.selectedArtist!.id;
    this.song!.artistName = this.selectedArtist!.name;
  }

  public artistUnselected(): void {
    this.song!.artistId = undefined;
    this.song!.artistName = '';
  }

  public getAllAlbums(event?: any): void {
    let albumSearch: string | undefined;
    if (event?.query) {
      albumSearch = event.query;
    }
    this.albumService.getAllAlbums(albumSearch).subscribe({
      next: (albumsFiltered) => {
        this.albums = albumsFiltered;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  public albumSelected(): void {
    this.song!.albumId = this.selectedAlbum!.id;
    this.song!.albumName = this.selectedAlbum!.name;
  }

  public albumUnselected(): void {
    this.song!.albumId = undefined;
    this.song!.albumName = '';
  }

  public saveSong(): void {
    if (this.mode === 'NEW') {
      this.insertSong();
    }

    if (this.mode === 'UPDATE') {
      this.updateSong();
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

  private insertSong(): void {
    this.songService.insert(this.song!).subscribe({
      next: (songInserted) => {
        console.log('Insertado correctamente');
        console.log(songInserted);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private updateSong(): void {
    this.songService.update(this.song!).subscribe({
      next: (songUpdated) => {
        console.log('Modificado correctamente');
        console.log(songUpdated);
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private getSongById(songId: number) {
    this.songService.getSongById(songId).subscribe({
      next: (songRequest) => {
        this.song = songRequest;
        this.selectedGenre = new Genre(
          songRequest.genreId!,
          songRequest.genreName!
        );
        this.selectedArtist = new Artist(
          songRequest.artistId!,
          songRequest.artistName!
        );
        this.selectedAlbum = new Album(
          songRequest.albumId!,
          songRequest.albumName!
        );
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private initializeSong(): void {
    this.song = new Song(
      undefined,
      '',
      0,
      '',
      undefined,
      '',
      undefined,
      '',
      undefined,
      '',
      ''
    );
  }

  private handleError(error: any): void {
    console.log(error);
  }
}
