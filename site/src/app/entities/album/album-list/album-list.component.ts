import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from '../model/album.model';
import { AlbumService } from '../service/album.service';

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.scss']
})
export class AlbumListComponent implements OnInit {
  albums: Album[] = [];

  albumIdToDelete?: number;

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService
  ) { }

  ngOnInit(): void {
    this.getAllAlbums();
  }

  public prepareAlbumToDelete(albumId: number): void {
    this.albumIdToDelete = albumId;
  }

  public deleteAlbum(): void {
    if (this.albumIdToDelete) {
      this.albumService.deleteAlbum(this.albumIdToDelete).subscribe({
        next: (data) => {
          this.getAllAlbums();
        },
        error: (err) => {this.handleError(err)}
      })
    }
  }

  private getAllAlbums(): void {
    this.albumService.getAllAlbums().subscribe({
      next: (albumRequest) => { this.albums = albumRequest; },
      error: (err) => { this.handleError(err); },
    });
  }

  private handleError(error: any): void {
    console.log(error);
  }

}
