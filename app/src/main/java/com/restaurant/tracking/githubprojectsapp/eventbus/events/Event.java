package com.restaurant.tracking.githubprojectsapp.eventbus.events;


import com.restaurant.tracking.githubprojectsapp.eventbus.models.EventPageInfo;

public class Event {

    public static class PostedModelEvent {
        private EventPageInfo model;

        public PostedModelEvent(EventPageInfo model) {
            this.model = model;
        }

        public EventPageInfo getModel() {
            return model;
        }

    }

}