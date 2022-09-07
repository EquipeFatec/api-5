<template>
    <div class="about">
        <div>
            <!-- <img alt="logo" src="../assets/logo_1.png" height="200" class="mr-2"> -->
            <img alt="logo" src="../assets/logoo.png" height="200" class="mr-2">
        </div>
        <div>
            <span class="p-float-label">
                <!-- <i class="pi pi-search" /> -->
                <InputText type="text" v-model="palavra" placeholder="Buscar" />
                <Button type="button" icon="pi pi-search" class="search" style="margin-left: 5px" @click="buscar" />

            </span>
        </div>
        <div class=" p-button-rounded">
            <Button label="Consultar Textos" class="p-button-outlined p-button-info" />
            <Button label="Consultar arquivos" class="p-button-outlined p-button-info" />
        </div>

        <Dialog class="busca" v-model:visible="displayModalBusca" :style="{ width: '100vw' }" :modal="true">
            <div class="card">

                <DataTable :value="word" sortMode="multiple" responsiveLayout="scroll">
                    <Column field="pa_palavra" header="Palavra" :sortable="true"></Column>
                    <Column field="pa_conjugacao" header="Conjugação" :sortable="true"></Column>
                    <Column field="pa_traducao" header="Tradução" :sortable="true"></Column>
                    <Column field="pa_aprovacao" header="Aprovação" :sortable="true"></Column>
                    <Column field="pa_significado" header="Significado" :sortable="true"></Column>
                    <Column field="pa_ex_aprovado" header="Exemplo Aprovado" :sortable="true"></Column>
                    <Column field="pa_classe_gramatical" header="Classe gramatical" :sortable="true"></Column>
                    <Column field="pa_categoria" header="Categoria dos nomes técnicos" :sortable="true"></Column>

                </DataTable>
            </div>
        </Dialog>
    </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Card from 'primevue/card';
import Panel from 'primevue/panel';
import InputText from 'primevue/inputtext';
import Menubar from 'primevue/menubar';
import { ref } from 'vue';
import Image from 'primevue/image';
import Button from 'primevue/button';
import Word from '@/components/Word.vue';
import Dialog from 'primevue/dialog';
import Column from 'primevue/column';
import DataTable from 'primevue/datatable';
import axios from "axios";

export default {
    name: 'AboutView',
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

    },
    data() { //onde se declara o objetos e variáveis
        return {
            displayModalBusca: false,
            word: [{
                "pa_palavra": "close", "pa_conjugacao": "fechar", "pa_traducao": "closed", "pa_aprovacao": 1,
                "pa_significado": "teste", "pa_ex_aprovado": "close in port", "pa_classe_gramatical": "verbo",
                "pa_categoria": "qualquer coisa"
            }],
            palavra: "",

        }
    },
    methods: { //todas as funções
        buscar() {
            this.displayModalBusca = true;
            axios.get("http://localhost:8082/search/" + this.palavra).then((response) => {
                this.palavra = response;
                console.log(response);
            })

        },
    },
}


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

