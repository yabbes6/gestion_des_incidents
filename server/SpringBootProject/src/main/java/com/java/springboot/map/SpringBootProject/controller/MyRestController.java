package com.java.springboot.map.SpringBootProject.controller;

public class MyRestController {

	/*@Autowired
	private UserRepository userRepository; // Assuming you have repositories for each entity
	@Autowired
	private IncidentRepository incidentRepository;
	@Autowired
	private CommentRepository commentRepository;

	// Create a new user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// Get all users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// Get user by ID
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found with id " + id));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// Create a new incident
	@PostMapping("/incidents")
	public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
		Incident savedIncident = incidentRepository.save(incident);
		return new ResponseEntity<>(savedIncident, HttpStatus.CREATED);
	}

	// Get all incidents
	@GetMapping("/incidents")
	public ResponseEntity<List<Incident>> getAllIncidents() {
		List<Incident> incidents = incidentRepository.findAll();
		return new ResponseEntity<>(incidents, HttpStatus.OK);
	}

	// Get incident by ID
	@GetMapping("/incidents/{id}")
	public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
		Incident incident = incidentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Incident not found with id " + id));
		return new ResponseEntity<>(incident, HttpStatus.OK);
	}

	// Create a new comment
	@PostMapping("/comments")
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		Comment savedComment = commentRepository.save(comment);
		return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
	}

	// Get all comments
	@GetMapping("/comments")
	public ResponseEntity<List<Comment>> getAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	// Get comment by ID
	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Comment not found with id " + id));
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	// Add an incident to a user's list of incidents
	@PostMapping("/users/{userId}/incidents/{incidentId}")
	public ResponseEntity<User> addIncidentToUser(@PathVariable Long userId, @PathVariable Long incidentId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("User not found with id " + userId));

		Incident incident = incidentRepository.findById(incidentId)
				.orElseThrow(() -> new NotFoundException("Incident not found with id " + incidentId));

		user.getIncidents().add(incident);
		userRepository.save(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// Add a comment to an incident
	@PostMapping("/incidents/{incidentId}/comments")
	public ResponseEntity<Incident> addCommentToIncident(@PathVariable Long incidentId, @RequestBody Comment comment) {
		Incident incident = incidentRepository.findById(incidentId)
				.orElseThrow(() -> new NotFoundException("Incident not found with id " + incidentId));

		comment.setIncident(incident);
		commentRepository.save(comment);

		return new ResponseEntity<>(incident, HttpStatus.OK);
	}

	// Implement other CRUD and relationship-related endpoints as needed

	// Exception handling
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}*/

}
