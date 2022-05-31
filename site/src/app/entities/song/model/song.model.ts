export class Song {
  id: number | undefined;
  name: string;
  length: number;
  release_date: string;
  genreId: number | undefined;
  genreName: string;
  artistId: number | undefined;
  artistName: string;
  albumId: number | undefined;
  albumName: string;
  albumImage: string;
  ratingId?: number | undefined;
  ratingValue?: string;
  viewsId?: number | undefined;
  viewsValue?: string;


  constructor(
    id: number | undefined,
    name: string,
    length: number,
    release_date: string,
    genreId: number | undefined,
    genreName: string,
    artistId: number | undefined,
    artistName: string,
    albumId: number | undefined,
    albumName: string,
    albumImage: string,
    ratingId?: number | undefined,
    ratingValue?: string,
    viewsId?: number | undefined,
    viewsValue?: string
) {
    this.id = id
    this.name = name
    this.length = length
    this.release_date = release_date
    this.genreId = genreId
    this.genreName = genreName
    this.artistId = artistId
    this.artistName = artistName
    this.albumId = albumId
    this.albumName = albumName
    this.albumImage = albumImage
    this.ratingId = ratingId
    this.ratingValue = ratingValue
    this.viewsId = viewsId
    this.viewsValue = viewsValue
  }


}
