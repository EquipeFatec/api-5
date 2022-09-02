<template>
  <FileUpload mode="basic" name="demo[]" url="./upload" :auto="true" />
  <main>
    <div v-if="!listaCSV" id="painelRedefinir">
      <h3 style="font-size: 30px">CSV não existente, informe</h3>
      <div style="display: flex; justify-content: center; margin: 30px">
        <csv-input :afterSubmit="loadCSV" />
        <FileUpload name="demo[]" url="./upload" />
      </div>
    </div>
  </main>
</template>

<script>
// import axios from "axios";
import { onBeforeMount } from "@vue/runtime-core";
import CsvInput from "../components/CSVInput.vue";
import FileUpload from "primevue/fileupload";
import Button from "primevue/button";

export default {
  data() {
    return {
      modoVisualizacao: "",
      listaCSV: [],
    };
  },
  name: "TelaUpload",
  components: {
    CsvInput,
    FileUpload,
    Button,
  },

  methods: {
    loadCSV: async function () {
      const headers = {
        "Content-Type": "multipart/form-data",
        Authorization: `Bearer ${localStorage.getItem("userToken")}`,
      };

      let response = await axios.get("http://localhost:8081/api/csv/csvdata", {
        headers,
      });
      this.listaCSV = response.data;
      console.log("teste primeiro");
    },

    created: async function () {
      await this.loadCSV();
      console.log("teste segundo", this.listaCSV);
    },
  },
};
</script>


<style scoped>
main {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 20px;
}

#painelRedefinir {
  width: 100%;
  min-width: 20%;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: white;
  margin-top: 60px;
  display: flex;
  flex-direction: column;
  background-color: rgb(48, 46, 54);
  padding: 20px;
  border-radius: 10px;
}
</style>