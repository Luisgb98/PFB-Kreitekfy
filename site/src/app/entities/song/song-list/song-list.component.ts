import { Component, OnInit } from '@angular/core';
import { Album } from '../../album/model/album.model';
import { Artist } from '../../artist/model/artist.model';
import { Genre } from '../../genre/model/genre.model';
import { Song } from '../model/song.model';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss'],
})
export class SongListComponent implements OnInit {
  genreId?: number;
  song?: Song;

  songs: Song[] = [];
  genres: Genre[] = [];
  artists: Artist[] = [];
  albums: Album[] = [];

  page: number = 0;
  size: number = 25;
  sort: string = 'name,asc';

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  nameFilter?: string;
  genreFilter?: string;
  artistFilter?: string;
  albumFilter?: string;

  songIdToDelete?: number;

  constructor(private songService: SongService) {}

  ngOnInit(): void {
    this.getAllSongs();
  }

  public prepareSongToDelete(songId: number): void {
    this.songIdToDelete = songId;
  }

  public deleteSong(): void {
    if (this.songIdToDelete) {
      this.songService.deleteSong(this.songIdToDelete).subscribe({
        next: (data) => {
          this.getAllSongs();
        },
        error: (err) => {
          this.handleError(err);
        },
      });
    }
  }

  public nextPage(): void {
    this.page = this.page + 1;
    this.getAllSongs();
  }

  public previousPage(): void {
    this.page = this.page - 1;
    this.getAllSongs();
  }

  public searchByFilters(): void {
    this.getAllSongs();
  }

  private buildFilters(): string | undefined {
    const filters: string[] = [];

    if (this.nameFilter) {
      filters.push('name:MATCH:' + this.nameFilter);
    }

    if (this.genreFilter) {
      filters.push('genre.name:EQUAL:' + this.genreFilter);
    }

    if (this.artistFilter) {
      filters.push('artist.name:EQUAL:' + this.artistFilter);
    }

    if (this.albumFilter) {
      filters.push('album.name:EQUAL:' + this.albumFilter);
    }

    if (filters.length > 0) {
      let globalFilters: string = '';
      for (let filter of filters) {
        globalFilters = globalFilters + filter + ',';
      }

      globalFilters = globalFilters.substring(0, globalFilters.length - 1);
      return globalFilters;
    } else {
      return undefined;
    }
  }

  private getAllSongs(): void {
    const filters: string | undefined = this.buildFilters();

    this.songService
      .getAllSongs(this.page, this.size, this.sort, filters)
      .subscribe({
        next: (data: any) => {
          this.songs = data.content;
          this.first = data.first;
          this.last = data.last;
          this.totalPages = data.totalPages;
          this.totalElements = data.totalElements;
        },
        error: (err) => {
          this.handleError(err);
        },
      });
  }

  private handleError(error: any): void {
    console.log(error);
  }
}
