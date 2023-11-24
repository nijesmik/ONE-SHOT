<template>
	<div>
		<v-btn variant="tonal" class="mb-2">주문 완료</v-btn>
		<v-dialog v-model="dialog" activator="parent" width="auto">
			<v-card>
				<v-card-text> 주문 완료하시겠습니까? </v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn
						color="primary-darken-1"
						variant="text"
						@click.prevent="orderComplete"
					>
						완료
					</v-btn>
					<v-btn color="red-darken-3" variant="text" @click="dialog = false">
						취소
					</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</div>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { ref } from "vue";
import axios from "axios";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const URL = useUrlStore();
const menuStore = useMenuStore();

const dialog = ref(false);

const orderComplete = () => {
	axios
		.patch(`${URL.API.ORDER_UPDATE}/${menuStore.order.orderId}`, {
			service: 1,
		})
		.then((res) => {
			location.reload();
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
