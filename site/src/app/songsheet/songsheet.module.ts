import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SongsheetRoutingModule } from './songsheet-routing.module';
import { SongsheetComponent } from './songsheet.component';


@NgModule({
  declarations: [
    SongsheetComponent
  ],
  imports: [
    CommonModule,
    SongsheetRoutingModule
  ]
})
export class SongsheetModule { }
