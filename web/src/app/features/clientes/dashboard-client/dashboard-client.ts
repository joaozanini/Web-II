import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { TagModule } from 'primeng/tag';
import { CardModule } from 'primeng/card';
import { BreadcrumbModule } from 'primeng/breadcrumb';

@Component({
  selector: 'app-dashboard-client',
  imports: [
    CommonModule,
    TableModule,
    ButtonModule,
    TagModule,
    CardModule,
    BreadcrumbModule
  ],
  templateUrl: './dashboard-client.html',
  styleUrl: './dashboard-client.css',
})

export class DashboardClient {

  breadcrumbItems = [
    { label: 'Usuário' },
    { label: 'Minhas solicitações' }
  ];

  solicitacoes = [
    {
      equipamento: 'Celular Galaxy S24 FE',
      data: '05/Mar/2026, 20:00',
      valor: 'R$75,00',
      estado: 'ORÇADA',
      classe: 'estado-orcada'
    },
    {
      equipamento: 'Notebook Asus',
      data: '05/Mar/2026, 20:00',
      valor: 'R$75,00',
      estado: 'APROVADA',
      classe: 'estado-aprovada'
    },
    {
      equipamento: 'DELL All-in-one inspiron 5430',
      data: '05/Mar/2026, 20:00',
      valor: 'R$75,00',
      estado: 'REJEITADA',
      classe: 'estado-rejeitada'
    },
    {
      equipamento: 'Impressora HP Ink Tank 416',
      data: '05/Mar/2026, 20:00',
      valor: 'R$75,00',
      estado: 'ARRUMADA',
      classe: 'estado-arrumada'
    }
  ];
  
  getEstadoClass(estado: string): string {

  switch (estado) {
    case 'ABERTA':
      return 'estado-aberta';

    case 'ORÇADA':
      return 'estado-orcada';

    case 'APROVADA':
      return 'estado-aprovada';

    case 'REJEITADA':
      return 'estado-rejeitada';

    case 'ARRUMADA':
      return 'estado-arrumada';

    default:
      return '';
  }

}

}