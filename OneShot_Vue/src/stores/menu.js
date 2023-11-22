import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useMenuStore = defineStore("menu", () => {
  const type = ref("");
  const temperature = ref("");
  const size = ref("");
  const orderId = ref(-1);
  const amount = ref(1);
  const menuDetail = ref({});
	return { type, temperature, size, orderId, amount, menuDetail };
});
