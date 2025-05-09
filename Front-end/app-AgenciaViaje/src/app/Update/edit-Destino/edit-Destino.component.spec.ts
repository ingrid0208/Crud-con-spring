import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DestinoComponent } from './edit-Destino.component';

describe('DestinoComponent', () => {
  let component: DestinoComponent;
  let fixture: ComponentFixture<DestinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DestinoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DestinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
