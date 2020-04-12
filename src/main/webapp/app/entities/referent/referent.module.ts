import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GestionPlateauSharedModule } from 'app/shared/shared.module';
import { ReferentComponent } from './referent.component';
import { ReferentDetailComponent } from './referent-detail.component';
import { ReferentUpdateComponent } from './referent-update.component';
import { ReferentDeleteDialogComponent } from './referent-delete-dialog.component';
import { referentRoute } from './referent.route';

@NgModule({
  imports: [GestionPlateauSharedModule, RouterModule.forChild(referentRoute)],
  declarations: [ReferentComponent, ReferentDetailComponent, ReferentUpdateComponent, ReferentDeleteDialogComponent],
  entryComponents: [ReferentDeleteDialogComponent]
})
export class GestionPlateauReferentModule {}
