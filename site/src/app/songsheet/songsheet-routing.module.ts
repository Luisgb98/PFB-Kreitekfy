import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SongsheetComponent } from './songsheet.component';

const routes: Routes = [{ path: '', component: SongsheetComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SongsheetRoutingModule { }
