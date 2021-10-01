package application.services;

import application.objects.State;
import org.springframework.stereotype.Service;

@Service
public class StatesService {

    public Object[] listAllStates()
    {
        return State.values();
    }
}
