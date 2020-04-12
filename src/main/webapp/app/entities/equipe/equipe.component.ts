import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IEquipe } from 'app/shared/model/equipe.model';
import { EquipeService } from './equipe.service';
import { EquipeDeleteDialogComponent } from './equipe-delete-dialog.component';

@Component({
  selector: 'jhi-equipe',
  templateUrl: './equipe.component.html'
})
export class EquipeComponent implements OnInit, OnDestroy {
  equipes?: IEquipe[];
  eventSubscriber?: Subscription;

  constructor(protected equipeService: EquipeService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.equipeService.query().subscribe((res: HttpResponse<IEquipe[]>) => (this.equipes = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInEquipes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IEquipe): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInEquipes(): void {
    this.eventSubscriber = this.eventManager.subscribe('equipeListModification', () => this.loadAll());
  }

  delete(equipe: IEquipe): void {
    const modalRef = this.modalService.open(EquipeDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.equipe = equipe;
  }
}
