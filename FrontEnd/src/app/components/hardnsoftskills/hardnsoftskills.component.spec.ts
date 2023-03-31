import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HardnsoftskillsComponent } from './hardnsoftskills.component';

describe('HardnsoftskillsComponent', () => {
  let component: HardnsoftskillsComponent;
  let fixture: ComponentFixture<HardnsoftskillsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HardnsoftskillsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HardnsoftskillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
