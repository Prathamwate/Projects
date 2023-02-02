package serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Todo;

@Service
public class TodoService {
	private List<Todo> todo=new ArrayList<>();
}
