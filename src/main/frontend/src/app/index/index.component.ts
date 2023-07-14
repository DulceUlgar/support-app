import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {
  apiData: any[] = []; // Creamos un array vacio para que lo rellene como un bollicao
  tableColumns: string[] = ['id', 'subject', 'description', 'user', 'date'];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // LLamamos a la api
    this.http.get<any[]>('http://localhost:8888/requests')
      .subscribe(data => {
        this.apiData = data;
      });
  }
}
