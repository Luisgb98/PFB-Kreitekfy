export class Artist {
  id: number | undefined;
  name: string;
  avatar?: string;
  birthdate?: string;

  constructor(
    id: number | undefined,
    name: string,
    avatar?: string,
    birthdate?: string
  ) {
    this.id = id;
    this.name = name;
    this.avatar = avatar;
    this.birthdate = birthdate;
  }
}
