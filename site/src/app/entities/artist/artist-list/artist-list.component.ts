import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Artist } from '../model/artist.model';
import { ArtistService } from '../service/artist.service';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.scss']
})
export class ArtistListComponent implements OnInit {
  artists: Artist[] = [];

  artistIdToDelete?: number;

  constructor(
    private route: ActivatedRoute,
    private artistService: ArtistService
  ) { }

  ngOnInit(): void {
    this.getAllArtists();
  }

  public prepareArtistToDelete(artistId: number): void {
    this.artistIdToDelete = artistId;
  }

  public deleteArtist(): void {
    if (this.artistIdToDelete) {
      this.artistService.deleteArtist(this.artistIdToDelete).subscribe({
        next: (data) => {
          this.getAllArtists();
        },
        error: (err) => {this.handleError(err)}
      })
    }
  }

  private getAllArtists(): void {
    this.artistService.getAllArtists().subscribe({
      next: (artistRequest) => { this.artists = artistRequest; },
      error: (err) => { this.handleError(err); },
    });
  }

  private handleError(error: any): void {
    console.log(error);
  }
}
