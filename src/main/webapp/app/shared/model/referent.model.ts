import { ICategorie } from 'app/shared/model/categorie.model';

export interface IReferent {
  id?: number;
  nom?: string;
  prenom?: string;
  telephone?: string;
  email?: string;
  categories?: ICategorie[];
}

export class Referent implements IReferent {
  constructor(
    public id?: number,
    public nom?: string,
    public prenom?: string,
    public telephone?: string,
    public email?: string,
    public categories?: ICategorie[]
  ) {}
}
