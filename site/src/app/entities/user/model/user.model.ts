export class User {
  id: number | undefined;
  name: string;
  email: string;
  password: string;
  rol: string;
  avatar?: string;
  birthdate?: string;

  constructor(
    id: number | undefined,
    name: string,
    email: string,
    password: string,
    rol: string,
    avatar?: string,
    birthdate?: string
  ) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.rol = rol;
    this.avatar = avatar;
    this.birthdate = birthdate;
  }
}
