import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICategorie, Categorie } from 'app/shared/model/categorie.model';
import { CategorieService } from './categorie.service';
import { IClub } from 'app/shared/model/club.model';
import { ClubService } from 'app/entities/club/club.service';
import { IReferent } from 'app/shared/model/referent.model';
import { ReferentService } from 'app/entities/referent/referent.service';

type SelectableEntity = IClub | IReferent;

@Component({
  selector: 'jhi-categorie-update',
  templateUrl: './categorie-update.component.html'
})
export class CategorieUpdateComponent implements OnInit {
  isSaving = false;
  clubs: IClub[] = [];
  referents: IReferent[] = [];

  editForm = this.fb.group({
    id: [],
    section: [],
    descrition: [],
    club: [],
    referent: []
  });

  constructor(
    protected categorieService: CategorieService,
    protected clubService: ClubService,
    protected referentService: ReferentService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ categorie }) => {
      this.updateForm(categorie);

      this.clubService.query().subscribe((res: HttpResponse<IClub[]>) => (this.clubs = res.body || []));

      this.referentService.query().subscribe((res: HttpResponse<IReferent[]>) => (this.referents = res.body || []));
    });
  }

  updateForm(categorie: ICategorie): void {
    this.editForm.patchValue({
      id: categorie.id,
      section: categorie.section,
      descrition: categorie.descrition,
      club: categorie.club,
      referent: categorie.referent
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const categorie = this.createFromForm();
    if (categorie.id !== undefined) {
      this.subscribeToSaveResponse(this.categorieService.update(categorie));
    } else {
      this.subscribeToSaveResponse(this.categorieService.create(categorie));
    }
  }

  private createFromForm(): ICategorie {
    return {
      ...new Categorie(),
      id: this.editForm.get(['id'])!.value,
      section: this.editForm.get(['section'])!.value,
      descrition: this.editForm.get(['descrition'])!.value,
      club: this.editForm.get(['club'])!.value,
      referent: this.editForm.get(['referent'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICategorie>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
