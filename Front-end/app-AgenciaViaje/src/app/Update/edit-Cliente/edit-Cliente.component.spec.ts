import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditClienteComponent } from './edit-Cliente.component';

describe('EditClienteComponent', () => {
  let component: EditClienteComponent;
  let fixture: ComponentFixture<EditClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditClienteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
