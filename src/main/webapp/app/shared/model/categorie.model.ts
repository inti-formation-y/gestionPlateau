import { IClub } from 'app/shared/model/club.model';
import { IReferent } from 'app/shared/model/referent.model';
import { Section } from 'app/shared/model/enumerations/section.model';

export interface ICategorie {
  id?: number;
  section?: Section;
  descrition?: string;
  club?: IClub;
  referent?: IReferent;
}

export class Categorie implements ICategorie {
  constructor(public id?: number, public section?: Section, public descrition?: string, public club?: IClub, public referent?: IReferent) {}
}
