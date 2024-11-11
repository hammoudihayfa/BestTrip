import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LodgingListComponent } from './components/lodging-list/lodging-list.component';
import { LodgingFormComponent } from './components/lodging-form/lodging-form.component';

const routes: Routes = [
  { path: 'lodgings', component: LodgingListComponent }, // Route to list lodging
  { path: 'add-lodging', component: LodgingFormComponent }, // Route to add a new lodging
  { path: '', redirectTo: '/lodgings', pathMatch: 'full' }, // Default route, redirects to /lodgings
  { path: '**', redirectTo: '/lodgings' } // Wildcard route for undefined paths (optional but recommended)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
