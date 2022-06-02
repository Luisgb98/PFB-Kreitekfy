import { Component, OnInit } from '@angular/core';
import { Song } from '../../song/model/song.model';
import { PlayerService } from '../service/player.service';

@Component({
  selector: 'app-player-new',
  templateUrl: './player-new.component.html',
  styleUrls: ['./player-new.component.scss'],
})
export class PlayerNewComponent implements OnInit {
  songs: Song[] = [];
  size: number = 5;
  sort: string = 'releaseDate,desc';
  constructor(private playerService: PlayerService) {}

  ngOnInit(): void {
    this.getAllSongs();
  }

  private handleError(error: any): void {
    console.log(error);
  }

  private getAllSongs(): void {
    const filters: string | undefined = this.buildFilters();

    this.playerService.getAllSongs(this.size, this.sort, filters).subscribe({
      next: (data: any) => {
        this.songs = data.content;
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private buildFilters(): string | undefined {
    const filters: string[] = [];

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
}
