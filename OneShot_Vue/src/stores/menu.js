import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useMenuStore = defineStore("menu", () => {
  // orderView
  const order = ref({});
  const orderDetails = ref([]);

  const type = ref("");
  const temperature = ref("");
  const size = ref("");
  const amount = ref(1);
  const menuDetail = ref({});
	return { type, temperature, size, amount, menuDetail, order, orderDetails };
});
