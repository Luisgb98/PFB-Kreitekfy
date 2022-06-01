import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../model/song.model';
import { SongService } from '../service/song.service';

@Component({
  selector: 'app-song-card',
  templateUrl: './song-card.component.html',
  styleUrls: ['./song-card.component.scss']
})
export class SongCardComponent implements OnInit {
  songId?: number;
  song?: Song;

  constructor(
    private route: ActivatedRoute,
    private songService: SongService
  ) { }

  ngOnInit(): void {
    this.songId = +this.route.snapshot.paramMap.get('songId')!;
    this.getSongById(this.songId!);
  }

  private getSongById(songId: number) {
    this.songService.getSongById(songId).subscribe({
      next: (songRequest) => {
        this.song = songRequest;
        //TODO
      },
      error: (err) => {
        this.handleError(err);
      },
    });
  }

  private handleError(err: any): void {
    // ToDo
  }

}
