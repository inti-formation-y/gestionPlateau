import { Groupe } from 'app/shared/model/enumerations/groupe.model';

export interface IEquipe {
  id?: number;
  nom?: string;
  nbrJoueurs?: number;
  groupe?: Groupe;
}

export class Equipe implements IEquipe {
  constructor(public id?: number, public nom?: string, public nbrJoueurs?: number, public groupe?: Groupe) {}
}
