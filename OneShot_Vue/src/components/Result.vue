<template>
	<v-list-item
		:title="orderDetail.name"
		:subtitle="content"
		:prepend-avatar="orderDetail.img"
	>
		<template v-if="isMine" v-slot:append>
			<div>
				<v-btn size="small" variant="text" icon="mdi-close"></v-btn>
				<v-dialog v-model="dialog" activator="parent" width="auto">
					<v-card>
						<v-card-text> 정말 삭제하시겠습니까? </v-card-text>
						<v-card-actions>
							<v-spacer></v-spacer>
							<v-btn
								color="red-darken-1"
								variant="text"
								@click.prevent="deleteOrder"
							>
								삭제
							</v-btn>
							<v-btn
								color="grey-darken-3"
								variant="text"
								@click="dialog = false"
							>
								취소
							</v-btn>
						</v-card-actions>
					</v-card>
				</v-dialog>
			</div>
		</template>
	</v-list-item>
</template>
<!-- --------------------------------------------------------------- -->
<script setup>
import { defineProps, ref } from "vue";
import axios from "axios";
import { useUrlStore } from "@/stores/url";
import { useMenuStore } from "@/stores/menu";

const props = defineProps({
	orderDetail: Object,
});
const menuStore = useMenuStore();
const orderDetailId = props.orderDetail.orderDetailId;
const name = localStorage.getItem(`oneshot-order-${orderDetailId}`);

const URL = useUrlStore();
const price = ref(props.orderDetail.unitPrice * props.orderDetail.amount);
const content = ref(
	`${props.orderDetail.menuName} / ${props.orderDetail.temperature} / ${props.orderDetail.sizeName} / ${props.orderDetail.amount}잔 / ${price.value}원`
);

const test = () => {
	if (menuStore.order.service > 0) {
		return false;
	}
	return props.orderDetail.name === name;
};
const isMine = ref(test());

const dialog = ref(false);

const deleteOrder = () => {
	axios
		.delete(`${URL.API.ORDER_DETAIL_DELETE}/${props.orderDetail.orderDetailId}`)
		.then((res) => {
			localStorage.removeItem(`oneshot-order-${orderDetailId}`);
			location.reload();
		});
};
</script>
<!-- --------------------------------------------------------------- -->
<style scoped></style>
