import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useMenuStore = defineStore("menu", () => {
  const type = ref("");
  const id = ref(0);
	return { type, id };
});
