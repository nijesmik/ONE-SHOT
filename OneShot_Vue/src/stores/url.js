import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useUrlStore = defineStore("url", () => {
	const DOMAIN = "https://oneshotcoffee.store";
	const _API = "https://oneshotserver.store/api";
  const _USER = `${_API}/user`;
	const _ORDER = `${_API}/order`;
	const _ORDER_DETAIL = `${_API}/order-detail`;
	const API = {
    LOGIN: `${_USER}/login`,
		SIGNUP: `${_USER}/signup`,
		BRAND: `${_API}/brand`,
		ORDER: _ORDER,
		ORDER_CREATE: `${_ORDER}/create`,
    MENU: `${_API}/menu`,
		MENU_DETAIL: `${_API}/menu-detail`,
		ORDER_DETAIL_CREATE: `${_ORDER_DETAIL}/create`,
	};

	return { DOMAIN, API };
});
