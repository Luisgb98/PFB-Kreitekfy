export class Article {
  private id: number;
  private genre: string;
  private length: string;
  private image: string;
  private release_date: string;
  private rating: number;
  private views: number;
  private artist: string;
  private album: string;

  public getId(): number {
    return this.id;
  }

  public setId(id: number): void {
    this.id = id;
  }

  public getGenre(): string {
    return this.genre;
  }

  public setGenre(genre: string): void {
    this.genre = genre;
  }

  public getLength(): string {
    return this.length;
  }

  public setLength(length: string): void {
    this.length = length;
  }

  public getImage(): string {
    return this.image;
  }

  public setImage(image: string): void {
    this.image = image;
  }

  public getRelease_date(): string {
    return this.release_date;
  }

  public setRelease_date(release_date: string): void {
    this.release_date = release_date;
  }

  public getRating(): number {
    return this.rating;
  }

  public setRating(rating: number): void {
    this.rating = rating;
  }

  public getViews(): number {
    return this.views;
  }

  public setViews(views: number): void {
    this.views = views;
  }

  public getArtist(): string {
    return this.artist;
  }

  public setArtist(artist: string): void {
    this.artist = artist;
  }

  public getAlbum(): string {
    return this.album;
  }

  public setAlbum(album: string): void {
    this.album = album;
  }

  constructor(
    id: number,
    genre: string,
    length: string,
    image: string,
    release_date: string,
    rating: number,
    views: number,
    artist: string,
    album: string
  ) {
    this.id = id;
    this.genre = genre;
    this.length = length;
    this.image = image;
    this.release_date = release_date;
    this.rating = rating;
    this.views = views;
    this.artist = artist;
    this.album = album;
  }
}
