<script setup type="ts">
import {onMounted, reactive, ref} from "vue";
import axios from "axios";

let values = reactive([]);

onMounted(() => {
  load();
})

let showCreateUpdate = ref(false);
let createButton = ref(true);
let todo = reactive({
  id: 0,
  name: "",
  description: ""
});

function load() {
  axios.get('http://localhost:8080/blueberry/todos').then(todo => {
    values = todo.data
  });
}

function create() {
  createButton = ref(true);
  axios.post('http://localhost:8080/blueberry/todos/create', JSON.stringify(todo), {
    headers: {
      "Content-Type": "application/json"
    }
  }).then(() => {
    load();
  });
}

function prepareUpdate(id) {
  showCreateUpdate = ref(true);
  createButton = ref(false);
  let localTodo = values.find(value => value.id === id);
  todo.id = localTodo.id;
  todo.name = localTodo.name;
  todo.description = localTodo.description;
}

function update() {
  axios.post('http://localhost:8080/blueberry/todos/update', JSON.stringify(todo), {
    headers: {
      "Content-Type": "application/json"
    }
  }).then(() => {
    load();
  });}

function deleteItem(id) {
  axios.post('http://localhost:8080/blueberry/todos/delete', JSON.stringify(values.find(value => value.id === id)), {
    headers: {
      "Content-Type": "application/json"
    }
  }).then(() => {
    load();
  });
}

</script>

<template>
  <button @click="showCreateUpdate=!showCreateUpdate">Add new</button>
  <p></p>

  <div v-if="showCreateUpdate">
    <h3>Name</h3>
    <input v-model="todo.name">
    <h3>Description</h3>
    <input v-model="todo.description">

    <p></p>
    <button @click="create">Create</button>
    <button @click="update">Update</button>
  </div>
  <p></p>

  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Actions</th>
    </tr>
    <tr v-for="value in values">
      <td>{{ value.id }}</td>
      <td>{{ value.name }}</td>
      <td>{{ value.description }}</td>
      <td>
        <button @click="prepareUpdate(value.id)">Update</button>
        <button @click="deleteItem(value.id)">Delete</button>
      </td>
    </tr>
  </table>
</template>

