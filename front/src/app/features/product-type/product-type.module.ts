import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductTypeListComponent } from './screens/product-type-list/product-type-list.component';
import { ProductTypeTableComponent } from './components/product-type-table/product-type-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';



@NgModule({
  declarations: [
    ProductTypeListComponent,
    ProductTypeTableComponent
  ],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule
  ],
  exports: [
    ProductTypeListComponent,
    ProductTypeTableComponent
  ]
})
export class ProductTypeModule { }
