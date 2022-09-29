<template>
  <Toast />
  <div class="about">
    <div>
      <img alt="logo" src="../assets/logoo.png" height="200" class="mr-2" />
    </div>

    <br/>
    <br/>

    <InputText type="text" v-model="login" placeholder="Login" />
    <br />
    <!-- <InputText type="text" v-model="senha" placeholder="Senha" /> -->
    <Password v-model="senha" placeholder="Senha" toggleMask></Password>

    <div class="p-button-rounded">
      <Button
        label="Entrar"
        class="p-button-outlined p-button-info"
        @click.prevent="entrar"
      />
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import Card from "primevue/card";
import Panel from "primevue/panel";
import InputText from "primevue/inputtext";
import Menubar from "primevue/menubar";
import { ref } from "vue";
import Image from "primevue/image";
import Button from "primevue/button";
import Word from "@/components/Word.vue";
import Dialog from "primevue/dialog";
import Column from "primevue/column";
import DataTable from "primevue/datatable";
import axios from "axios";
import Toast from "primevue/toast";
import Password from 'primevue/password';


export default {
  name: "Login",
  components: {
    HelloWorld,
    Card,
    Panel,
    InputText,
    Menubar,
    Image,
    Button,
    Word,
    Dialog,
    Column,
    DataTable,
    Toast,
    Password
  },
  data() {
    //onde se declara o objetos e variáveis
    return {
      login: '',
      senha: ''
    };
  },

  methods: {
    //todas as funções
    entrar() {
      
      const headers = { 'Content-Type': 'application/json'}

      const body = { 
        username: this.login, 
        password: this.senha 
      }
      axios
        .post("http://localhost:8082/login", body, headers)
        .then(result => {
          if (result.data !== "" && result.status === 200) {
            console.log(result);
            const token = result.headers.token;
            localStorage.setItem('userToken', token);
            
            this.$router.push('/tela-upload');
          }

        })
        .catch((error) => {
          this.$toast.add({
            severity: "error",
            summary: "Erro no servidor",
            life: 10000,
          });
        });
    },
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.about {
  background-color: rgba(242, 248, 248, 0.452);
  height: 100vh;
  justify-content: center;
  display: flex;
  align-items: center;
  flex-direction: column;
}

.mr-2 {
  width: 270px;
  height: auto;
}

.p-float-label {
  margin-top: 10px;
}

.p-inputtext {
  width: 500px;
  border-radius: 9px;
  border-color: rgb(39, 39, 88);
}

.p-button-rounded {
  margin-top: 15px;
  display: flex;
  width: 25%;
  size: 25px;
  justify-content: space-around;
  border-radius: 55px;
}

.p-button-outlined p-button-info {
  border-color: rgb(70, 70, 175);
}

.search {
  margin-top: 15px;
  display: flex;
  width: 25%;
  size: 25px;
  justify-content: space-around;
  border-radius: 55px;
}
</style> >

