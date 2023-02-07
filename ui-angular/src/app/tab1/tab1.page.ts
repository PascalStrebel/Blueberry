import {Component, OnInit} from '@angular/core';
import axios from "axios";

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit{

  values: any[] = [];

  constructor() {}

  ngOnInit(): void {
    this.load();
  }

  private load(): void{
    axios.get('http://localhost:8080/blueberry/todos').then(todo => {
      this.values = todo.data
    });
  }

}
