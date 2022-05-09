class SubscriptionController {
    SubscriberService subscriptionService
    def save()
    {
        Long id = Long.parseLong(params.id)
        String seriousness = params.seriousness
        User user = session.user
        Subscription subscription = subscriptionService.save(id,seriousness,user)
        if (subscription == null)
            render "Error saving Subscription"
        else
            render "Subscription saved Successfully"
    }
    def update()
    {
        Long id = Long.parseLong(params.id)
        Subscription subscription = subscriptionService.check(id)
        if (subscription == null)
        {
            render "Subscription id invalid"
        }
        else {
            subscriptionService.update(subscription,params.seriousness)
            render "Subscription updated Successfully"
        }
    }
    def delete()
    {
        Long id = Long.parseLong(params.id)
        Integer flag = subscriptionService.delete(id)
        if (flag == 0)
            render "Subscription with this id cannot be found"
        else
            render "Subscription deleted"
    }
}
