import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { UnassignedOrdersComponent } from './unassigned-orders/unassigned-orders.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: 'all-orders', component: AllOrdersComponent },
  { path: 'my-orders', component: MyOrdersComponent },
  { path: 'order/:id', component: OrderDetailsComponent },
  { path: 'unassigned-orders', component: UnassignedOrdersComponent },
  { path: 'users', component: UsersComponent },
  { path: 'login', component: LoginPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
