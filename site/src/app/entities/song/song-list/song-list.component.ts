import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../model/song.model';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss']
})
export class SongListComponent implements OnInit {
  genreId?: number;
  songs: Song[] = [];

  page: number = 0;
  size: number = 25;
  sort: string = "name,asc";

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  nameFilter?: string;
  priceFilter?: number;

  songIdToDelete?: number;

  constructor(
    private route: ActivatedRoute,
    private songService: SongService
  ) { }

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
        error: (err) => {this.handleError(err)}
      })
    }
  }

  public nextPage(): void {
    this.page = this.page + 1;
    this.getAllSongs();
  }

  public previousPage():void {
    this.page = this.page - 1;
    this.getAllSongs();
  }

  public searchByFilters(): void {
    this.getAllSongs();
  }

  private buildFilters(): string | undefined {
    const filters: string[] = [];

    if (this.genreId) {
      filters.push("genre.id:EQUAL:" + this.genreId);
    }

    if (this.nameFilter) {
      filters.push("name:MATCH:" + this.nameFilter);
    }

    if (filters.length > 0) {
      let globalFilters: string = "";
      for (let filter of filters) {
        globalFilters = globalFilters + filter + ","
      }

      globalFilters = globalFilters.substring(0, globalFilters.length-1);
      return globalFilters;

    } else {
      return undefined;
    }

  }

  private getAllSongs(): void {
    const filters: string | undefined = this.buildFilters();

    this.songService.getAllSongs(this.page, this.size, this.sort, filters).subscribe({
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

