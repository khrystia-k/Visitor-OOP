package ua.ucu.edu.apps.task2;

public class Stamping {
    
    public static <T> Group<T> stampGroupWithId(Group<T> group) {
        for (Task<T> task : group.getTasks()) {
            if (task instanceof Signature) {
                Signature<T> signature = (Signature<T>) task;
                signature.setHeader("groupId", group.groupUuid);
            } else if (task instanceof Group) {
                stampGroupWithId((Group<T>) task);
            }
        }
        return group;
    }
}