<template>
    <Toast>
        <div class="buscar">
            <div class="menu">
                <MegaMenu :model="items" />
            </div>
            <div class="card">
                <Splitter
                    style="height:37rem; width:60rem; margin-left:60%; margin-bottom: 10%; margin-top: 10%; margin-right: 90%;  margin-left: 0%; background-color: #F2E0F7; text-align:center">
                    <SplitterPanel>
                        <Card style="width: 100%; height: 100%; margin-bottom: 45%; justify-content: center;">
                            <template #title> Inclusão de palavra </template>
                            <template #content>
                                <div class="card">
                                    <div class=".p-input">
                                        <span class="p-float-label" style="margin-bottom: 25%; margin-top: 0%;">
                                            <InputText type="text" v-model="palavra" placeholder="Buscar" />
                                            <InputText type="text" v-model="conjunção" placeholder="Conjunção" />
                                            <InputText type="text" v-model="traducao" placeholder="Tradução" />
                                            <InputText type="text" v-model="aprovada" placeholder="Aprovada" />
                                            <InputText type="text" v-model="significado" placeholder="Significado" />
                                            <InputText type="text" v-model="exemploAprovado"
                                                placeholder="Exemplo aprovado" />
                                            <InputText type="text" v-model="classeGramatical"
                                                placeholder="Classe gramatical" />
                                            <InputText type="text" v-model="categoria" placeholder="Categoria" />
                                            <div class="buttons">
                                                <button @click="buscar">Inserir</button>

                                            </div>

                                        </span>
                                    </div>
                                </div>
                            </template>
                        </Card>
                    </SplitterPanel>
                    <SplitterPanel>
                        <Card style="width: 100%; height: 100%; margin-bottom: 80%">
                            <template #title> Inclusão de palavra </template>
                            <template #content>
                                <div class="card">
                                    <div class=".p-input">
                                        <span class="p-float-label">
                                            <InputText type="text" v-model="palavra" placeholder="Palavra" />
                                            <div class="field col-12 md:col-4">
                                                <span class="p-float-label">
                                                    <Dropdown id="dropdown" v-model="value8" :options="cities"
                                                        optionLabel="name" />
                                                    <label for="dropdown"> Classe Gramatical</label>
                                                </span>
                                            </div>
                                            <Button label="Editar" type="button" class="buttons"
                                                style="margin-left: 5px" @click="displayModalBusca" />
                                        </span>

                                        <Dialog class="busca" v-model:visible="displayModalBusca"
                                            :style="{ width: '100vw' }" :modal="true">

                                            <h2> Cadastro de palavras</h2>
                                            <input type="text" name="Palavra" placeholder="Palavra" id="palavra">
                                            <input type="text" name="Conjucacao" placeholder="Conjunção"
                                                id="conjucacao">
                                            <input type="text" name="Tradução" placeholder="Tradução" id="traducao">
                                            <input type="text" name="Aprovada" placeholder="Aprovada" id="aprovada">
                                            <input type="text" name="Significado" placeholder="Significado"
                                                id="significado">
                                            <input type="text" name="Exemplo aprovado" placeholder="Exemplo aprovado"
                                                id="exemplo">
                                            <input type="text" name="Classe gramatical" placeholder="Classe gramatical"
                                                id="classe">
                                            <input type="text" name="Categoria" placeholder="Categoria" id="categoria">
                                            <button @click="buscar">Cadastrar</button>
                                        </Dialog>
                                    </div>
                                </div>
                            </template>
                        </card>
                    </SplitterPanel>

                </Splitter>
            </div>

        </div>


    </Toast>
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
import Dropdown from 'primevue/dropdown';
import Splitter from 'primevue/splitter';
import SplitterPanel from 'primevue/splitterpanel';

export default {
    name: 'BuscarView',
    components: {
        HelloWorld,
        Card,
        Panel,
        InputText,
        Menubar,
        Image,
        Button,
        Dropdown,
        Splitter,
        SplitterPanel

    },
    data() {
        return {
            displayModalBusca: false,
            cities: [
                { name: 'Verbo', code: 'Verbo' },
                { name: 'Substantivo', code: 'Substantivo' },
                { name: '', code: '' },
                { name: '', code: '' },
                { name: '', code: '' }
            ],
            items: [
                {
                    label: 'Configurações da conta', icon: 'pi pi-fw pi-cog',
                    items: [
                        [
                            {
                                label: 'Nome',
                                items: [{ label: 'Setting 1.1' }, { label: 'Setting 1.2' }]
                            },
                            {
                                label: 'Setting 2',
                                items: [{ label: 'Setting 2.1' }, { label: 'Setting 2.2' }]
                            },
                            {
                                label: 'Setting 3',
                                items: [{ label: 'Setting 3.1' }, { label: 'Setting 3.2' }]
                            }
                        ],
                        [
                            {
                                label: 'Setting 4',
                                items: [{ label: 'Setting 4.1' }, { label: 'Setting 4.2' }]
                            }
                        ]
                    ]
                },
                {
                    label: 'Arquivo', icon: 'pi pi-fw pi-cloud-upload',
                    items: [
                        [
                            {
                                label: 'Nome',
                                items: [{ label: 'Setting 1.1' }, { label: 'Setting 1.2' }]
                            }
                        ]
                    ]
                }
            ]
        }
    },
    methods: {
        openModalBusca() {
            this.displayModalBusca = true;
        },
        toggle(event) {
            this.$refs.menu.toggle(event);
        },
        save() {
            this.$toast.add({ severity: 'success', summary: 'Success', detail: 'Data Saved', life: 3000 });
        }
    },
}
</script>

<style>
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

.buscar {
    background-color: rgba(242, 248, 248, 0.452);
    height: 100vh;
    justify-content: center;
    padding: 10px;
    display: flex;
    align-items: center;
    flex-direction: column;
    margin-top: 0%;
    margin-right: 50%;
    margin-bottom: 50%;
}

.menu {
    background-color: aqua;

}

.card {
    flex-direction: column;
    width: 35%;
    padding: 20px;
    margin-top: 10%;
}

.p-input {

    width: 90px;
    border-radius: 2px;
    border-color: rgb(39, 39, 88);
}


.mr-2 {
    width: 270px;
    height: auto;
}

.p-input-icon-left {

    margin-top: 10px;

}

.p-inputtext {
    width: 500px;
    border-radius: 9px;
    border-color: rgb(39, 39, 88);
}

.p-button-outlined p-button-info {
    border-color: rgb(70, 70, 175);
}

.buttons {
    margin-top: 20px;
    display: flex;
    width: 100%;
    justify-content: center;
}

.buttons button:nth-child(1) {
    margin-right: 50px;
}

.buttons button {
    width: 150px;
    height: 40px;
    background: #2196F3;
    border: solid 1px #2196F3;
    transition: 0.2s;
    border-radius: 3px;
    color: #fff;
    font-weight: 700;
    font-size: 1rem
}

.buttons button:hover {
    background: #fff;
    color: #2196F3;
}


.p-button.p-component {
    width: 150px;
    height: 40px;
    background: #2196F3;
    border: solid 1px #2196F3;
    transition: 0.2s;
    border-radius: 3px;
    color: #fff;
    font-weight: 700;
    margin-top: 20px;
    padding: 0;
    font-size: 1rem
}

.flex {
    align-items: center;
    justify-content: center;
    width: 150%;
}

.p-card-content {
    align-items: center;
    justify-content: center;
    width: 150%;
}
</style> >

