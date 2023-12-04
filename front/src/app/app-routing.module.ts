import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductTypeListComponent } from './features/product-type/screens/product-type-list/product-type-list.component';

const routes: Routes = [
  {
    path: 'product-type/list',
    component: ProductTypeListComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
