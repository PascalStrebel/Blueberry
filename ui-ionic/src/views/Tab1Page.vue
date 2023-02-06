<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Tab 1</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Tab 1</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-grid>
        <ion-row>
          <ion-col>ID</ion-col>
          <ion-col>Name</ion-col>
          <ion-col>Beschreibung</ion-col>
          <ion-col>Funktionen</ion-col>
        </ion-row>
        <ion-row v-for="value in values">
          <ion-col>{{ value.id }}</ion-col>
          <ion-col>{{ value.name }}</ion-col>
          <ion-col>{{ value.description }}</ion-col>
          <ion-col><ion-button @click="deleteItem(value.id)">Delete</ion-button></ion-col>
        </ion-row>
      </ion-grid>

      <ion-button @click="showCreateUpdate=!showCreateUpdate">Add Item</ion-button>

      <div v-if="showCreateUpdate">
        <ion-item>
          <ion-label>Name</ion-label>
          <ion-input v-model="todo.name"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label>Beschreibung</ion-label>
          <ion-input v-model="todo.description"></ion-input>
        </ion-item>

        <ion-button @click="create">Create</ion-button>
      </div>

    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonGrid, IonRow, IonCol, IonButton, IonLabel, IonInput, IonItem} from '@ionic/vue';
import {onMounted, reactive, ref} from "vue";
import axios from "axios";

let todo = reactive({
  id: 0,
  name: "",
  description: ""
});
let values = reactive([]);
let showCreateUpdate = ref(false);

onMounted(() => {
  load();
})

function load() {
  axios.get('http://localhost:8080/blueberry/todos').then(todo => {
    values = todo.data
  });
}

function create() {
  console.log(todo)
  axios.post('http://localhost:8080/blueberry/todos/create', JSON.stringify(todo), {
    headers: {
      "Content-Type": "application/json"
    }
  }).then(() => {
    load();
  });
}

function deleteItem(id: number) {
  console.log(values)
  console.log(id)
  axios.post('http://localhost:8080/blueberry/todos/delete', JSON.stringify(values.find((value: any) => value.id === id)), {
    headers: {
      "Content-Type": "application/json"
    }
  }).then(() => {
    load();
  });
}

</script>

<style scoped>
ion-col {
  background-color: #135d54;
  border: solid 1px #fff;
  color: #fff;
  text-align: center;
}
</style>
