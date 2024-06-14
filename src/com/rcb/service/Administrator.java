package com.rcb.service;

import java.util.ArrayList;

import com.rcb.bean.RouteBean;
import com.rcb.bean.ScheduleBean;
import com.rcb.bean.ShipBean;

public interface Administrator {

	Object addShip(ShipBean sb);

	Object removeShip(String shipId);

	ShipBean viewShip(String shipId);

	Object modifyShip(ShipBean sb);

	Object addRoute(RouteBean rb);

	Object removeRoute(String routeId);

	RouteBean viewRoute(String routeId);

	Object modifyRoute(RouteBean rb);

	Object addSchedule(ScheduleBean sb);

	Object removeSchedule(String scheduleId);

	ScheduleBean viewSchedule(String scheduleId);

	Object modifySchedule(ScheduleBean scb);

	ArrayList<ShipBean> viewAllShip();

	ArrayList<RouteBean> viewAllRoutes();

	ArrayList<ScheduleBean> viewAllSchedules();

}
