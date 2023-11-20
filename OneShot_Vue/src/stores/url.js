import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useUrlStore = defineStore("url", () => {
	const DOMAIN = "http://localhost:8080";
	const _API = `${DOMAIN}/api`;
  const _USER = `${_API}/user`;
	const _ORDER = `${_API}/order`;
	const API = {
    LOGIN: `${_USER}/login`,
		BRAND: `${_API}/brand`,
		ORDER: _ORDER,
		ORDER_CREATE: `${_ORDER}/create`,
    MENU: `${_API}/menu`,
	};

	return { DOMAIN, API };
});
