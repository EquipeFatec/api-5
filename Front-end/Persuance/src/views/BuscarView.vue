<template>
    <div class="buscar">
        <div>
            <Toast />

            <h5>Inline</h5>
            <Menu :model="items" />

            <h5>Overlay</h5>
            <Button type="button" label="Toggle" @click="toggle" aria-haspopup="true" aria-controls="overlay_menu" />
            <Menu id="overlay_menu" ref="menu" :model="items" :popup="true" />
            <!-- <img alt="logo" src="../assets/logo_1.png" height="200" class="mr-2"> -->
            <img alt="logo" src="../assets/logoo.png" height="200" class="mr-2">
        </div>
        <div>
            <span class="p-input-icon-left">
                <i class="pi pi-search" />
                <InputText type="text" v-model="value3" placeholder="Search" />
                <!-- <Button icon="pi pi-search" class="p-button-rounded" /> -->
            </span>
        </div>
        <div class="p-button-rounded">
            <Button label="Consultar Textos" class="p-button-outlined p-button-info" />
            <Button label="Consultar arquivos" class="p-button-outlined p-button-info" />
        </div>

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
import Menu from 'primevue/menu';

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
        Menu
    },
    data() {
        return {
            items: [
                {
                    label: 'Options',
                    items: [{
                        label: 'Update',
                        icon: 'pi pi-refresh',
                        command: () => {
                            this.$toast.add({ severity: 'success', summary: 'Updated', detail: 'Data Updated', life: 3000 });
                        }
                    },
                    {
                        label: 'Delete',
                        icon: 'pi pi-times',
                        command: () => {
                            this.$toast.add({ severity: 'warn', summary: 'Delete', detail: 'Data Deleted', life: 3000 });
                        }
                    }
                    ]
                },
                {
                    label: 'Navigate',
                    items: [{
                        label: 'Vue Website',
                        icon: 'pi pi-external-link',
                        url: 'https://vuejs.org/'
                    },
                    {
                        label: 'Router',
                        icon: 'pi pi-upload',
                        command: () => {
                            window.location.hash = "/fileupload"
                        }
                    }
                    ]
                }
            ]
        }
    },
    methods: {
        toggle(event) {
            this.$refs.menu.toggle(event);
        },
        save() {
            this.$toast.add({ severity: 'success', summary: 'Success', detail: 'Data Saved', life: 3000 });
        }
    }
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
     display: flex;
     align-items: center;
     flex-direction: column;
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
 </style> >

