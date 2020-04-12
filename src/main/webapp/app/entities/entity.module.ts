import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'club',
        loadChildren: () => import('./club/club.module').then(m => m.GestionPlateauClubModule)
      },
      {
        path: 'stade',
        loadChildren: () => import('./stade/stade.module').then(m => m.GestionPlateauStadeModule)
      },
      {
        path: 'categorie',
        loadChildren: () => import('./categorie/categorie.module').then(m => m.GestionPlateauCategorieModule)
      },
      {
        path: 'equipe',
        loadChildren: () => import('./equipe/equipe.module').then(m => m.GestionPlateauEquipeModule)
      },
      {
        path: 'referent',
        loadChildren: () => import('./referent/referent.module').then(m => m.GestionPlateauReferentModule)
      },
      {
        path: 'plateau',
        loadChildren: () => import('./plateau/plateau.module').then(m => m.GestionPlateauPlateauModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class GestionPlateauEntityModule {}
