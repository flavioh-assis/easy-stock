import { Component,  ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

interface ProductType {
  id: number;
  name: string;
}

@Component({
  selector: 'app-product-type-table',
  templateUrl: './product-type-table.component.html',
  styleUrls: ['./product-type-table.component.less'],
})
export class ProductTypeTableComponent {
  dataSource: MatTableDataSource<ProductType>;
  displayedColumns: string[] = [
    'id', 'name'
  ];
  types: string[] = [
    'Parachoque Dianteiro',
    'Parachoque Traseiro',
    'Porta Motorista Direita',
    'Porta Motorista Esquerda',
    'Porta Passageiro Direita',
    'Porta Passageiro Esquerda',
    'Capô',
    'Porta-malas',
  ]

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor() {
    this.dataSource = new MatTableDataSource(
        this.types.map((name, id) => {
          return {
            id: id + 1,
            name
          }
        })
    );
  }
}
